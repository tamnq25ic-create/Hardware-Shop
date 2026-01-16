/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MainStuffs;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author MacKa
 */
public class JpanelLoader {
   
  public void jPanelLoader(JPanel mainPanel, JPanel panel) {
        mainPanel.removeAll();
        mainPanel.setLayout(new BorderLayout());

        mainPanel.add(panel, BorderLayout.CENTER);

        mainPanel.revalidate();
        mainPanel.repaint();
    }
   
}
