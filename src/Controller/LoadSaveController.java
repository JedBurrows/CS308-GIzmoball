package Controller;

import Model.Absorber;
import Model.Ball;
import Model.Board;
import Model.Exceptions.NoSuchGizmoException;
import Model.GizmoCreator;
import Model.Gizmos.Flipper;
import Model.Gizmos.GizmoCircle;
import Model.Gizmos.IGizmo;
import Model.Gizmos.Square;
import View.BoardPanel;

import javax.swing.*;
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
            if (fc.getSelectedFile().isDirectory()) {
                //TODO SAVING
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
                                                        board.setAbsorber(new Absorber(name, x1, y1, x2, y2));
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
//                                                        board.addGizmoBall(new Ball(name, x, y, 0.1f,0.1f));
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
//                                                board.addGizmo(gizmoCreator.createGizmo(name, x1, y1), x1, y1);
												switch (element) {
													case "Square":
														board.addGizmo(new Square(name, x1, y1));
														System.out.println("Created new " + element);
														break;
													case "Circle":
														board.addGizmo(new GizmoCircle(name, x1, y1));
														System.out.println("Created new " + element);
														break;
													case "Triangle":
														//board.addGizmo(new Triangle(name, x1, y1), x1, y1);
														System.out.println("Created new " + element);
														break;
													case "RightFlipper":
														board.addGizmo(new Flipper(name, x1, y1, true));
														System.out.println("Created new " + element);
														break;
													case "LeftFlipper":
														board.addGizmo(new Flipper(name, x1, y1, false));
														System.out.println("Created new " + element);
														break;
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
        if (command == "save") {
            save();
        } else if (command == "Load") {
            panel.setBoard(load());


        }

    }
}
