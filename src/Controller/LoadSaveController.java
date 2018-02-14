package Controller;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class LoadSaveController implements ActionListener {
	private Component panel;

	public LoadSaveController(Component panel){
		this.panel = panel;
	}

	public void save(){
		JFileChooser fc = new JFileChooser();
		fc.setDialogTitle("Save");
		int returnVal = fc.showSaveDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION){
			if(fc.getSelectedFile().isDirectory()){

			}
		}


	}
	public Board load(){
		JFileChooser fc = new JFileChooser();
		fc.setDialogTitle("Open");
		int returnVal = fc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			if (fc.getSelectedFile().isFile()) {
				File file = fc.getSelectedFile();
				try{
					FileReader fileReader = new FileReader(file);

					BufferedReader bufferedReader = new BufferedReader(fileReader);
					Board board = new Board();
					String line = bufferedReader.readLine();
					while (line != null){
						Scanner scanner = new Scanner(line);

						if(scanner.hasNext()){
							String element = scanner.next();
							System.out.println("First element pulled from line was: " + element);

							switch (element){

							/*
								"Absorber" (IDENTIFIER name) (INTEGER x1) (INTEGER y1) (INTEGER x2) (INTEGER y2)
								Creates an absorber with its upper left-hand corner at (x1,y1) and its lower right-hand corner at (x2,y2)

							 */
								case "Absorber":
									System.out.println("'Absorber' - command in file in file, cannot create absorber");
									break;

								/*
									"Ball" (IDENTIFIER name) (FLOAT x) (FLOAT y) (FLOAT vx) (FLOAT vy)
									Name must be unique, x and y refer to positions, vx and vy refer to velocity.
								 */
								case  "Ball":
									String name;
									float x,y,vx,vy;
									//Not pretty but effective, TODO maybe come up of a cleaner way log some better display messages maybe.
									if (scanner.hasNext()){
										name = scanner.next();
										if (scanner.hasNextFloat()){
											x = scanner.nextFloat();
											if (scanner.hasNextFloat()){
												y=scanner.nextFloat();
												if (scanner.hasNextFloat()){
													vx=scanner.nextFloat();
													if (scanner.hasNextFloat()){
														vy=scanner.nextFloat();

														board.addGizmoBall(new Ball(name,x,y,vx,vy));
													}else{
														System.out.println("Ball command missing vy velocity or velocity is not of type float.");
													}
												}else{
													System.out.println("Ball command missing vx velocity or velocity is not of type float.");
												}
											}else{
												System.out.println("Ball command missing y coordinate or coordinate is not of type float.");
											}
										}else{
											System.out.println("Ball command missing x coordinate or coordinate is not of type float.");
										}
									}else{
										System.out.println("Ball command missing name or has incorrect name.");
									}
									break;

								/*
									"Rotate" (IDENTIFIER name)
								 */
								case "Rotate":
									IGizmo gizmo = board.getGizmoByID(scanner.next());
									if (gizmo!= null){
										gizmo.rotate();
									}
									break;

								/*
									"Delete" (IDENTIFIER name)
								 */
								case "Delete":
									System.out.println("'Delete' - command in file in file, cannot delete.");

									break;

								/*
									"Move" (IDENTIFIER name) (INTEGER x) (INTEGER y)
									"Move" (IDENTIFIER name) (FLOAT x) (FLOAT y)
									In the first form, moves the gizmo with the given name so that its upper-left corner is at (x,y). In the second form, moves the ball with the given name so that its center is at (x,y).
								 */
								case "Move":
									System.out.println("'Move' - command in file in file, cannot move.");

									break;

								/*
									"Connect" (IDENTIFIER producer) (IDENTIFIER consumer)
								 */
								case "Connect":
									System.out.println("'Connect' - command in file in file, cannot connect.");

									break;

								/*
									"KeyConnect" "key" (KEYNUM num) "down" (IDENTIFIER consumer)
									"KeyConnect" "key" (KEYNUM num) "up" (IDENTIFIER consumer)
								 */
								case "KeyConnect":
									System.out.println("'Absorber' - command in file in file, cannot create absorber");

									break;

								/*
									"Gravity" (FLOAT g)
								 */
								case "Gravity":
									board.setGravity(scanner.nextFloat());
									break;

								/*
									"Friction" (FLOAT mu) (FLOAT mu2)
								 */
								case "Friction":
									board.setFriction(scanner.nextFloat(),scanner.nextFloat());

									break;

							/*
								<gizmoOp> (IDENTIFIER name) (INTEGER x) (INTEGER y)
								Creates the given gizmo with its upper left-corner at (x,y), in the default orientation.
							 */
								case "Square":
									board.addGizmo(new Square(scanner.next()),scanner.nextInt(),scanner.nextInt());
									break;
								case "Circle":
									board.addGizmo(new GizmoCircle(scanner.next()),scanner.nextInt(),scanner.nextInt());
									break;
								case "Triangle":
									board.addGizmo(new Triangle(scanner.next()),scanner.nextInt(),scanner.nextInt());
									break;
								case "RightFlipper":
									System.out.println("'RightFlipper' - command in file in file, cannot create RightFlipper");
									break;
								case "LeftFlipper":
									System.out.println("'LeftFlipper' - command in file in file, cannot create LeftFlipper");
									break;
								//may need case for empty line or return carriage
							}

						}


						line = bufferedReader.readLine();


					}


				}catch(FileNotFoundException e){

				}catch (IOException e){

				}

			}
		}
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent e){
		String command = e.getActionCommand();
		if (command == "save"){
			save();
		}else if (command == "load"){
			load();

		}

	}
}
