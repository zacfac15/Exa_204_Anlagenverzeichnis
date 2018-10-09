package GUI;

import code.AnlageModel;


import code.TableCellRenderer;

import javax.swing.JOptionPane;



public class AnlageGUI extends javax.swing.JFrame
{

  private AnlageModel model = new AnlageModel();

  public AnlageGUI()
  { 
    initComponents();
    jtAnlage.setModel(model);
    jtAnlage.setDefaultRenderer(Object.class, new TableCellRenderer());
    try
    {
      model.loadFile();
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    

  }

  


@SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents()
  {

    jLabel5 = new javax.swing.JLabel();
    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    cbYear = new javax.swing.JComboBox<>();
    jButton1 = new javax.swing.JButton();
    jLabel4 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    jtAnlage = new javax.swing.JTable();

    jLabel5.setText("jLabel5");

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel1.setLayout(new java.awt.GridLayout(1, 5));

    jLabel1.setText("Year");
    jPanel1.add(jLabel1);

    jPanel1.add(cbYear);

    jButton1.setText("Update Table");
    jButton1.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        onUpdate(evt);
      }
    });
    jPanel1.add(jButton1);
    jPanel1.add(jLabel4);
    jPanel1.add(jLabel2);
    jPanel1.add(jLabel3);

    getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

    jtAnlage.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][]
      {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}
      },
      new String []
      {
        "Title 1", "Title 2", "Title 3", "Title 4"
      }
    ));
    jScrollPane1.setViewportView(jtAnlage);

    getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void onUpdate(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onUpdate
  {//GEN-HEADEREND:event_onUpdate

  }//GEN-LAST:event_onUpdate

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new AnlageGUI().setVisible(true);
        });
    }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JComboBox<String> cbYear;
  private javax.swing.JButton jButton1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable jtAnlage;
  // End of variables declaration//GEN-END:variables
}
