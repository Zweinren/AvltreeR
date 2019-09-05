/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolavl;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author Dren
 */
public class ventana extends javax.swing.JFrame {
Graphics g;
    public static final int an = 50;
    public static final int diam = 30;
    public static final int r = diam / 2;
    Metodos arbol;
    Recorridos R;
     Nodo raiz=null;
    /**
     * Creates new form ventana
     */
    public ventana() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        agragarB = new javax.swing.JButton();
        Panel = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        agragarB.setText("Agregar");
        agragarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agragarBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(agragarB))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(agragarB)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agragarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agragarBActionPerformed
       int i = Integer.parseInt(JOptionPane.showInputDialog("Digite el valor:"));
        if (g==null ) {
             g = Panel.getGraphics();
            arbol= new Metodos();
        }
       int x= Panel.getWidth()/2;
       JOptionPane.showMessageDialog(null, x);
       raiz=Metodos.insertarAVL(raiz,i);
       R.preOrdenNR(raiz);
       pintarr(g,x/2,20,raiz);
    }//GEN-LAST:event_agragarBActionPerformed

   
    
        public void pintarr(Graphics g, int x, int y, Nodo n) {
            if (n == null)
        {}
        else {
            System.out.println(arbol.completos(n)+" completos");
            int EXTRA = arbol.completos(n) * (an / 2);
            g.drawOval(x, y, diam, diam);
            if (n.getIzquierdo()!= null)
                g.drawLine(x + r, y + r, x - an - EXTRA + r, y + r + an);
                g.setColor(Color.BLACK);
            if (n.getDerecho() != null) 
                g.drawLine(x + r, y + r, x + an + EXTRA + r, y + r + an);
                g.setColor(Color.BLACK);
                g.fillOval(x, y, diam, diam);
                
                pintarr(g,x - an - EXTRA ,y + an,n.getIzquierdo());
                pintarr(g,x + an + EXTRA ,y + an,n.getDerecho());
                g.setColor(Color.yellow);
                String dato=""+n.getDato();
            g.drawString(dato, x + 12, y + 18);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventana().setVisible(true);
            }
        });
    }
       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Panel;
    private javax.swing.JButton agragarB;
    // End of variables declaration//GEN-END:variables
}
