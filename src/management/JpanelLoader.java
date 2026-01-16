/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import javax.swing.GroupLayout;
import javax.swing.JPanel;

/**
 *
 * @author MacKa
 */
public class JpanelLoader {
   
   public  void jPanelLoader(JPanel Main,JPanel setPanel){
     Main.removeAll();

        // tạo layout mới cho Main
        GroupLayout layout = new GroupLayout(Main);
        Main.setLayout(layout);

        // set auto gaps
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // set horizontal group
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                  .addComponent(setPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        // set vertical group
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                  .addComponent(setPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Main.revalidate(); // refresh layout
        Main.repaint();    // repaint panel
    }
   
}
