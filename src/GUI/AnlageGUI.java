package GUI;

import bl.AnlageModel;
import bl.AnlagenTableRenderer;
import javax.swing.JOptionPane;

public class AnlageGUI extends javax.swing.JFrame {

    private final AnlageModel model = new AnlageModel();

    public AnlageGUI() {
        initComponents();
        jtAnlage.setModel(model);
        jtAnlage.setDefaultRenderer(Object.class, new AnlagenTableRenderer());
        
        try {
            model.loadFile();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        for (int i = 2000; i <= 2100; i++) {
            cbYear.addItem(i + "");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        paYear = new javax.swing.JPanel();
        lbYear = new javax.swing.JLabel();
        cbYear = new javax.swing.JComboBox<>();
        btUpdateTable = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAnlage = new javax.swing.JTable();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        paYear.setLayout(new java.awt.GridLayout(1, 5));

        lbYear.setText("Year");
        paYear.add(lbYear);

        paYear.add(cbYear);

        btUpdateTable.setText("Update Table");
        btUpdateTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onUpdate(evt);
            }
        });
        paYear.add(btUpdateTable);
        paYear.add(jLabel4);
        paYear.add(jLabel2);
        paYear.add(jLabel3);

        getContentPane().add(paYear, java.awt.BorderLayout.PAGE_START);

        jtAnlage.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtAnlage);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void onUpdate(java.awt.event.ActionEvent evt)//GEN-FIRST:event_onUpdate
  {//GEN-HEADEREND:event_onUpdate
      model.updateTable(Integer.parseInt((String) cbYear.getSelectedItem()));
  }//GEN-LAST:event_onUpdate

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new AnlageGUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btUpdateTable;
    private javax.swing.JComboBox<String> cbYear;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtAnlage;
    private javax.swing.JLabel lbYear;
    private javax.swing.JPanel paYear;
    // End of variables declaration//GEN-END:variables
}
