package Controller;

import Model.*;
import Model.Gizmos.*;


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

							String name;
							float x,y,vx,vy,mu1,mu2,g;
							int x1,x2,y1,y2;

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
									try{
										IGizmo gizmo = board.getGizmoByID(scanner.next());
										if (gizmo!= null){
											gizmo.rotate();
										}
									}catch(Board.NoSuchGizmoException e){
										System.out.println("Gizmo with the specified id does not exist.");
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
									System.out.println("'KeyConnect' - command in file in file, cannot create absorber");

									break;

								/*
									"Gravity" (FLOAT g)
								 */
								case "Gravity":
									if (scanner.hasNextFloat()){
										g = scanner.nextFloat();
										board.setGravity(g);
									}else{
										System.out.println("");
									}
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
									if (scanner.hasNext()){
										name = scanner.next();
										if (scanner.hasNextInt()){
											x1 = scanner.nextInt();
											if (scanner.hasNextInt()){
												y1 = scanner.nextInt();
												board.addGizmo(new Square(name,x1,y1),x1,y1);
											}else{
												System.out.println("Square command missing y position or position is not of type int.");
											}
										}else {
											System.out.println("Square command missing x position or position is not of type int.");
										}
									}else {
										System.out.println("Square command missing name.");
									}

									break;

								case "Circle":
									if (scanner.hasNext()){
										name = scanner.next();
										if (scanner.hasNextInt()){
											x1 = scanner.nextInt();
											if (scanner.hasNextInt()){
												y1 = scanner.nextInt();
												board.addGizmo(new GizmoCircle(name,x1,y1),x1,y1);
											}else{
												System.out.println("Circle command missing y position or position is not of type int.");
											}
										}else {
											System.out.println("Circle command missing x position or position is not of type int.");
										}
									}else {
										System.out.println("Circle command missing name.");
									}
									break;

								case "Triangle":
									if (scanner.hasNext()){
										name = scanner.next();
										if (scanner.hasNextInt()){
											x1 = scanner.nextInt();
											if (scanner.hasNextInt()){
												y1 = scanner.nextInt();
												board.addGizmo(new Triangle(name,x1,y1),x1,y1);
											}else{
												System.out.println("Triangle command missing y position or position is not of type int.");
											}
										}else {
											System.out.println("Triangle command missing x position or position is not of type int.");
										}
									}else {
										System.out.println("Triangle command missing name.");
									}
									break;

								case "RightFlipper":
									if (scanner.hasNext()){
										name = scanner.next();
										if (scanner.hasNextInt()){
											x1 = scanner.nextInt();
											if (scanner.hasNextInt()){
												y1 = scanner.nextInt();
												board.addGizmo(new Flipper(name,x1,y1,Flipper.FLIPPER_RIGHT),x1,y1);
											}else{
												System.out.println("RightFlipper command missing y position or position is not of type int.");
											}
										}else {
											System.out.println("RightFlipper command missing x position or position is not of type int.");
										}
									}else {
										System.out.println("RightFlipper command missing name.");
									}
									break;
								case "LeftFlipper":
									if (scanner.hasNext()){
										name = scanner.next();
										if (scanner.hasNextInt()){
											x1 = scanner.nextInt();
											if (scanner.hasNextInt()){
												y1 = scanner.nextInt();
												board.addGizmo(new Flipper(name,x1,y1,Flipper.FLIPPER_RIGHT),x1,y1);
											}else{
												System.out.println("LeftFlipper command missing y position or position is not of type int.");
											}
										}else {
											System.out.println("LeftFlipper command missing x position or position is not of type int.");
										}
									}else {
										System.out.println("LeftFlipper command missing name.");
									}
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
