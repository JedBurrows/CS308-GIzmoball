package Controller;

import Model.Board;

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
					String line = bufferedReader.readLine();
					while (line != null){
						Scanner scanner = new Scanner(line);

						String element = scanner.next();

						switch (element){

							/*
								"Absorber" (IDENTIFIER name) (INTEGER x1) (INTEGER y1) (INTEGER x2) (INTEGER y2)
								Creates an absorber with its upper left-hand corner at (x1,y1) and its lower right-hand corner at (x2,y2)

							 */
							case "Absorber":
								break;

								/*
									"Ball" (IDENTIFIER name) (FLOAT x) (FLOAT y) (FLOAT vx) (FLOAT vy)
									Name must be unique, x and y refer to positions, vx and vy refer to velocity.

								 */
							case  "Ball":
								break;

								/*
									"Rotate" (IDENTIFIER name)
								 */
							case "Rotate":
								break;

								/*
									"Delete" (IDENTIFIER name)
								 */
							case "Delete":
								break;

								/*
									"Move" (IDENTIFIER name) (INTEGER x) (INTEGER y)
									"Move" (IDENTIFIER name) (FLOAT x) (FLOAT y)
									In the first form, moves the gizmo with the given name so that its upper-left corner is at (x,y). In the second form, moves the ball with the given name so that its center is at (x,y).
								 */
							case "Move":
								break;

								/*
									"Connect" (IDENTIFIER producer) (IDENTIFIER consumer)
								 */
							case "Connect":
								break;

								/*
									"KeyConnect" "key" (KEYNUM num) "down" (IDENTIFIER consumer)
									"KeyConnect" "key" (KEYNUM num) "up" (IDENTIFIER consumer)
								 */
							case "KeyConnect":
								break;

								/*
									"Gravity" (FLOAT g)
								 */
							case "Gravity":
								break;

								/*
									"Friction" (FLOAT mu) (FLOAT mu2)
								 */
							case "Friction":
								break;


							/*
								<gizmoOp> (IDENTIFIER name) (INTEGER x) (INTEGER y)
								Creates the given gizmo with its upper left-corner at (x,y), in the default orientation.
							 */
							case "Square":
								break;
							case "Circle":
								break;
							case "Triangle":
								break;
							case "RightFlipper":
								break;
							case "LeftFlipper":
								break;
						}


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
