package Controller;

import Model.*;
import Model.Exceptions.NoSuchGizmoException;
import Model.Gizmos.IGizmo;
import View.BoardPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class LoadSaveController implements ActionListener {
    private BoardPanel panel;


    public LoadSaveController(BoardPanel p) {
        panel = p;
    }

    public void save() {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Save");
        int returnVal = fc.showSaveDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            //TODO SAVING
            System.out.println(fc.getSelectedFile().getName());
            try {
                File saveFile = fc.getSelectedFile();
                FileWriter fileWriter = new FileWriter(saveFile);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                //Write gizmos to file
                //TODO not writing Flippers since class name is just "Flipper" not "LeftFlipper" or "RightFlipper"

                IBoard board = panel.getBoard();
                for (IGizmo gizmo : board.getGizmos()) {
                    String type = gizmo.getClass().getSimpleName();

                    bufferedWriter.write(type + " " + gizmo.getID() + " " + gizmo.getPos1().x + " " + gizmo.getPos1().y);
                    if (type.equals("Absorber")) {
                        bufferedWriter.write(" " + gizmo.getPos2().x + " " + gizmo.getPos2().y);
                    }
                    bufferedWriter.newLine();

                    int rotations = gizmo.getRotation();
                    if (rotations > 0 && !type.equals("Absorber")) {
                        for (int x = 0; x < rotations; x++) {
                            bufferedWriter.write("Rotate" + " " + gizmo.getID());
                            bufferedWriter.newLine();

                        }
                    }

                        Color color = gizmo.getColor();
                        bufferedWriter.write("Color " + gizmo.getID() + " " +color.getRed()+" "+color.getGreen()+" "+color.getBlue());
                        bufferedWriter.newLine();


                }

                for (Connector connection : board.getConnectors()) {
                    bufferedWriter.write("Connect" + " " + connection.getSource().getID() + " " + connection.getTarget().getID());
                    bufferedWriter.newLine();
                }

                if (panel.getBoard().hasGizmoBall()) {
                    Ball ball = board.getBall();

                    bufferedWriter.write("Ball" + " " + ball.getName() + " " + ball.getXPos() + " " + ball.getYPos() + " " + ball.getVelo().x() + " " + ball.getVelo().y());
                    bufferedWriter.newLine();
                }


                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {

            }

        }
    }

    private Board load() {
        Board board = new Board();
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Open");
        GizmoCreator gizmoCreator = new GizmoCreator();
        int returnVal = fc.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            if (fc.getSelectedFile().isFile()) {
                File file = fc.getSelectedFile();
                try {
                    FileReader fileReader = new FileReader(file);

                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String line = bufferedReader.readLine();
                    while (line != null) {
                        Scanner scanner = new Scanner(line);

                        if (scanner.hasNext()) {
                            String element = scanner.next();

                            String name, producer, consumer;
                            float x, y, vx, vy, mu1, mu2, g;
                            int x1, x2, y1, y2;

                            switch (element) {

							/*
                                "Absorber" (IDENTIFIER name) (INTEGER x1) (INTEGER y1) (INTEGER x2) (INTEGER y2)
								Creates an absorber with its upper left-hand corner at (x1,y1) and its lower right-hand corner at (x2,y2)

							 */
                                case "Absorber":
                                    if (scanner.hasNext()) {
                                        name = scanner.next();
                                        if (scanner.hasNextInt()) {
                                            x1 = scanner.nextInt();
                                            if (scanner.hasNextInt()) {
                                                y1 = scanner.nextInt();
                                                if (scanner.hasNextInt()) {
                                                    x2 = scanner.nextInt();
                                                    if (scanner.hasNextInt()) {
                                                        y2 = scanner.nextInt();
                                                        board.addGizmo(gizmoCreator.createAbsorber(name, x1, y1, x2, y2, Color.PINK));
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                    }

								/*
									"Ball" (IDENTIFIER name) (FLOAT x) (FLOAT y) (FLOAT vx) (FLOAT vy)
									Name must be unique, x and y refer to positions, vx and vy refer to velocity.
								 */
                                case "Ball":

                                    //Not pretty but effective, TODO maybe come up of a cleaner way log some better display messages maybe.
                                    if (scanner.hasNext()) {
                                        name = scanner.next();
                                        if (scanner.hasNextFloat()) {
                                            x = scanner.nextFloat();
                                            if (scanner.hasNextFloat()) {
                                                y = scanner.nextFloat();
                                                if (scanner.hasNextFloat()) {
                                                    vx = scanner.nextFloat();
                                                    if (scanner.hasNextFloat()) {
                                                        vy = scanner.nextFloat();
                                                        board.addGizmoBall(name, x, y, vx, vy);
                                                    } else {
                                                        System.out.println("Ball command missing vy velocity or velocity is not of type float.");
                                                    }
                                                } else {
                                                    System.out.println("Ball command missing vx velocity or velocity is not of type float.");
                                                }
                                            } else {
                                                System.out.println("Ball command missing y coordinate or coordinate is not of type float.");
                                            }
                                        } else {
                                            System.out.println("Ball command missing x coordinate or coordinate is not of type float.");
                                        }
                                    } else {
                                        System.out.println("Ball command missing name or has incorrect name.");
                                    }
                                    break;

								/*
									"Rotate" (IDENTIFIER name)
								 */
                                case "Rotate":
                                    try {
                                        IGizmo gizmo = board.getGizmoByID(scanner.next());
                                        if (gizmo != null) {
                                            gizmo.rotate();
                                        }
                                    } catch (NoSuchGizmoException e) {
                                        System.out.println("Gizmo with the specified id does not exist.");
                                    }
                                    break;

                                    /*
                                    "Color"(IDENTIFIER name)
                                     */
                                case "Color":
                                    try {
                                        IGizmo gizmo = board.getGizmoByID(scanner.next());
                                        int red = scanner.nextInt();
                                        int green = scanner.nextInt();
                                        int blue = scanner.nextInt();
                                        Color color = new Color(red,green,blue);
                                        if (gizmo != null) {
                                            gizmo.setColor(color);
                                        }
                                    } catch (NoSuchGizmoException e) {
                                        System.out.println("Gizmo with the specified id does not exist.");
                                    }
                                    break;

								/*
									"Delete" (IDENTIFIER name)
								 */
                                case "Delete":
                                    if (scanner.hasNext()) {
                                        name = scanner.next();
                                        board.deleteGizmo(name);
                                    }

                                    break;

								/*
									"Move" (IDENTIFIER name) (INTEGER x) (INTEGER y)
									"Move" (IDENTIFIER name) (FLOAT x) (FLOAT y)
									In the first form, moves the gizmo with the given name so that its upper-left corner is at (x,y). In the second form, moves the ball with the given name so that its center is at (x,y).
								 */
                                case "Move":
                                    if (scanner.hasNext()) {
                                        name = scanner.next();
                                        if (scanner.hasNextFloat()) {
                                            x = scanner.nextFloat();
                                            if (scanner.hasNextFloat()) {
                                                y = scanner.nextFloat();
                                                board.moveBall();
                                            }

                                        } else if (scanner.hasNextInt()) {
                                            x1 = scanner.nextInt();
                                            if (scanner.hasNextInt()) {
                                                y1 = scanner.nextInt();
                                                board.moveGizmo(name, x1, y1);
                                            }

                                        }
                                    }
                                    break;

								/*
									"Connect" (IDENTIFIER producer) (IDENTIFIER consumer)
								 */
                                case "Connect":
                                    if (scanner.hasNext()) {
                                        producer = scanner.next();
                                        if (scanner.hasNext()) {
                                            consumer = scanner.next();

                                            board.addConnector(producer, consumer);
                                        }

                                    }
                                    break;

								/*
									"KeyConnect" "key" (KEYNUM num) "down" (IDENTIFIER consumer)
									"KeyConnect" "key" (KEYNUM num) "up" (IDENTIFIER consumer)
								 */
                                case "KeyConnect":
                                    System.out.println("'KeyConnect' - command in file in file, cannot create KeyConnect");

                                    break;

								/*
									"Gravity" (FLOAT g)
								 */
                                case "Gravity":
                                    if (scanner.hasNextFloat()) {
                                        g = scanner.nextFloat();
                                        board.setGravity(g);
                                    } else {
                                        System.out.println("");
                                    }
                                    break;

								/*
									"Friction" (FLOAT mu) (FLOAT mu2)
								 */
                                case "Friction":
                                    board.setFriction(scanner.nextFloat(), scanner.nextFloat());

                                    break;

							/*
								<gizmoOp> (IDENTIFIER name) (INTEGER x) (INTEGER y)
								Creates the given gizmo with its upper left-corner at (x,y), in the default orientation.
							 */

                                //TODO Change to used gizmo creator
                                //ToDo Add colours to saved gizmos- all green for now
                                case "Square":
                                case "Circle":
                                case "Triangle":
                                case "RightFlipper":
                                case "LeftFlipper":
                                    //From here
                                    if (scanner.hasNext()) {
                                        name = scanner.next();
                                        if (scanner.hasNextInt()) {
                                            x1 = scanner.nextInt();
                                            if (scanner.hasNextInt()) {
                                                y1 = scanner.nextInt();
												switch (element) {
													case "Square":
													case "Circle":
													case "Triangle":
													case "RightFlipper":
													case "LeftFlipper":
                                                        board.addGizmo(gizmoCreator.createGizmo(element, name, x1, y1, Color.GREEN));


                                                }
                                            } else {
                                                System.out.println(element + " command missing y position or position is not of type int.");
                                            }
                                        } else {
                                            System.out.println(element + " command missing x position or position is not of type int.");
                                        }
                                    } else {
                                        System.out.println(element + " command missing name.");
                                    }
                                    //may need case for empty line or return carriage
                            }
                        }
                        line = bufferedReader.readLine();
                    }

                } catch (FileNotFoundException e) {


                } catch (IOException e) {

                }

            }
        }


        board.notifyObservers();
        return board;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();
        System.out.println(command);
        if (command == "Save") {
            save();
        } else if (command == "Load") {
            panel.setBoard(load());


        }

    }
}
