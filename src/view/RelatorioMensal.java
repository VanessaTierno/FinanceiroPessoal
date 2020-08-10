/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import br.com.vanessa.financeiroPessoal.DAO.RegistroDAO;
import br.com.vanessa.financeiroPessoal.model.Registro;
import java.awt.Component;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Vanessa
 */
public class RelatorioMensal extends javax.swing.JFrame {
    private String tipo;

    /**
     * Creates new form Relatorio
     */
    public RelatorioMensal() {
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

        registro1 = new br.com.vanessa.financeiroPessoal.model.Registro();
        jMesAno = new javax.swing.JTextField();
        despesa = new java.awt.Checkbox();
        receita = new java.awt.Checkbox();
        todos = new java.awt.Checkbox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPesquisar = new javax.swing.JToggleButton();
        BtnSair = new javax.swing.JButton();
        jTotal = new javax.swing.JLabel();
        imprimir = new java.awt.Button();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jMesAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 180, -1));

        despesa.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        despesa.setLabel("Despesa");
        despesa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                despesaItemStateChanged(evt);
            }
        });
        getContentPane().add(despesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 90, -1));

        receita.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        receita.setLabel("Receita");
        receita.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                receitaItemStateChanged(evt);
            }
        });
        receita.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                receitaInputMethodTextChanged(evt);
            }
        });
        getContentPane().add(receita, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 90, -1));

        todos.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        todos.setLabel("Todos");
        todos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                todosItemStateChanged(evt);
            }
        });
        getContentPane().add(todos, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 90, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Valor", "Parcela", "Desconto", "Valor da Parcela", "Tipo", "Data de Vencimento", "Data de Pagamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 850, 410));

        jPesquisar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/icons/document.png"))); // NOI18N
        jPesquisar.setText("Pesquisar");
        jPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(jPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, 250, 50));

        BtnSair.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BtnSair.setText("Sair");
        BtnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSairActionPerformed(evt);
            }
        });
        getContentPane().add(BtnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 630, -1, -1));

        jTotal.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Total:"));
        getContentPane().add(jTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 90, 170, 40));

        imprimir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        imprimir.setLabel("Imprimir");
        imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirActionPerformed(evt);
            }
        });
        getContentPane().add(imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 570, 120, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Mês/Ano:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/relatorioFundo.jpg"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(600, 400));
        jLabel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jLabel1FocusGained(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 910, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabel1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1FocusGained
    
    
    
    private void jPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPesquisarActionPerformed
         readJTable(RegistroDAO.pesquisarMensal(jMesAno.getText(), tipo));
         jTotal.setText(RegistroDAO.somarMes(jMesAno.getText(), tipo).toString());
    }//GEN-LAST:event_jPesquisarActionPerformed

    private void despesaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_despesaItemStateChanged
         tipo = "'Despesa'"; 
         todos.setState(false);
         receita.setState(false);
    }//GEN-LAST:event_despesaItemStateChanged

    private void receitaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_receitaInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_receitaInputMethodTextChanged

    private void receitaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_receitaItemStateChanged
         tipo = "'Receita'"; 
         todos.setState(false);
         despesa.setState(false);
    }//GEN-LAST:event_receitaItemStateChanged

    private void todosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_todosItemStateChanged
         tipo = "'Despesa', 'Receita'"; 
         despesa.setState(false);
         receita.setState(false);
    }//GEN-LAST:event_todosItemStateChanged

    private void imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirActionPerformed
        imprimir("C:\\User\\Br\\Desktop\\teste.txt");
        
    }//GEN-LAST:event_imprimirActionPerformed

    private void BtnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_BtnSairActionPerformed
    
    public String retornaTipo (String[] args) {
        String resultado = null;
        
        return resultado;
    }
    
    
    
    public void readJTable( List<Registro> lst) {
        
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        
        String [] cols = {"Descrição", "Valor", "Parcela", "Desconto", "Valor da Parcela", "Tipo", "Data de Vencimento", "Data de Pagamento"};
        modelo.setColumnIdentifiers(cols);
        modelo.setNumRows(0);
        
        for(Registro r :lst){
            modelo.addRow(new Object[]{
                r.getDescricao(),
                r.getValor(),
                r.getParcela(),
                r.getDesconto(),
                r.getValorParcela(),
                r.getTipo(),
                formatarData(r.getDataVencimento()),
                formatarData(r.getDataPagamento())
            });
       
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
            java.util.logging.Logger.getLogger(RelatorioMensal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioMensal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioMensal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioMensal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioMensal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnSair;
    private java.awt.Checkbox despesa;
    private java.awt.Button imprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jMesAno;
    private javax.swing.JToggleButton jPesquisar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jTotal;
    private java.awt.Checkbox receita;
    private br.com.vanessa.financeiroPessoal.model.Registro registro1;
    private java.awt.Checkbox todos;
    // End of variables declaration//GEN-END:variables

    private Component getJTable1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void imprimir(String pCaminhoDoArquivo) {
       
        Desktop desktop = Desktop.getDesktop();
    
        try {
            File arquivoAImprimir = new File(pCaminhoDoArquivo);
            desktop.print(arquivoAImprimir);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void ShowData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        private String formatarData(Calendar data) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(data.getTime());
    }
}