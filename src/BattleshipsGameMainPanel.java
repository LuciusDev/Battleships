/*
* This class is the main grid square
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BattleshipsGameMainPanel extends JPanel implements MouseListener {
    private String name;
    private boolean isPlayer;
    
    private boolean hasShip;
    private boolean isHit;
    
    public BattleshipsGameMainPanel(boolean isPlayer, String name) {
        this.isPlayer = isPlayer;
        this.name = name;
        
        setBackground(BattleshipsMainFrame.NORMAL_COLOUR);
        addMouseListener(this);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setPreferredSize(new Dimension(30, 30));
    }
    
    //returns hasShip
    public boolean getHasShip() {
        return hasShip;
    }
    //returns isHits
    public boolean getIsHit() {
        return isHit;
    }
    //returns the name
    public String getName() {
        return name;
    }
    //returns isPlayer
    public boolean getIsPlayer() {
        return isPlayer;
    }
    
    //called when the user fires on that panel
    public void setHit() {
        isHit = true;
        if(hasShip) {
            setBackground(BattleshipsMainFrame.HIT_COLOUR);
        } else {
            setBackground(BattleshipsMainFrame.MISS_COLOUR);
        }
    }
    //called when there is supposed to be a ship there
    public void setShip() {
        hasShip = true;
        if(isPlayer) {
            setBackground(BattleshipsMainFrame.SHIP_COLOUR);
        }
    }
    
    //mouse listeners
    public void mouseClicked(MouseEvent e) {
        if(!isPlayer) {
            BattleshipsGamePanel.controlLocationLabel.setText(name);
        }
    }
    
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    
    public void mouseEntered(MouseEvent e) {
        if(!isHit && !isPlayer) {
            setBackground(BattleshipsMainFrame.HOVER_COLOUR);
        }
    }
    
    public void mouseExited(MouseEvent e) {
        if(!isHit && !isPlayer) {
            setBackground(BattleshipsMainFrame.NORMAL_COLOUR);
        }
    }
}
