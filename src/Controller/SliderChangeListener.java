package Controller;

import View.BuildGUI;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSlider;

public class SliderChangeListener implements ChangeListener {
	BuildGUI buildGUI;
	private float friction_mu1;
	private float friction_mu2;

	public SliderChangeListener(BuildGUI buildGUI){
		this.buildGUI = buildGUI;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
        JSlider s = (JSlider) e.getSource();
        String slider_type = s.getName();
        switch(slider_type) {
            case ("mu"):
                friction_mu1 = s.getValue();
                buildGUI.getBoardPanel().getBoard().setFriction(friction_mu1,friction_mu2);
                break;
            case ("mu2"):
                friction_mu2 = s.getValue();
                buildGUI.getBoardPanel().getBoard().setFriction(friction_mu1, friction_mu2);
                break;
            case ("gravity"):
                buildGUI.getBoardPanel().getBoard().setGravity(s.getValue());
                break;
        }
	}



}
