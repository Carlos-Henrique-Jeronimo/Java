/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

import static banco.Banco.main;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class Cliente {
    private String nome;
    private String email;
    private String num_conta;
  
    private float valor_conta = 0;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNum_conta() {
        return num_conta;
    }

    public void setNum_conta(String num_conta) {
        this.num_conta = num_conta;
    }

    public float getValor_conta() {
        return valor_conta;
    }

    public void setValor_conta(float valor_conta) {
        this.valor_conta = valor_conta;
    }

    
    
    
    public void escolher(){
        String [] opcoes = {"Depositar","Sacar","Criar conta","Exibir","Fechar"};
        int op = JOptionPane.showOptionDialog(null, "Escolha", "Faça sua escolha", 0,JOptionPane.QUESTION_MESSAGE , null, opcoes, "");
        switch (op) {
            case 0:
                this.depositar();
                this.escolher();
                break;
            case 1:
                this.sacar();
                this.escolher();
                break;
            case 2:
                this.criarConta();
                this.escolher();
                break;
            case 3:
                this.exibir();
                this.escolher();
            default:
                throw new AssertionError();
        }
    }
    
    
    
    public void depositar(){
      int deposito;
        if (this.nome == null) {
            JOptionPane.showMessageDialog(null, "Sem conta");
            this.criarConta();
            
        }else{
            deposito = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor do depósito: "));
            this.valor_conta += deposito;
            JOptionPane.showMessageDialog(null, "Foi depositado: "+deposito + " R$. Seu saldo atual é: "+this.valor_conta+" R$");
        }
        
    }
    public void criarConta(){
        setNome(JOptionPane.showInputDialog("Digite o nome:"));
        setEmail(JOptionPane.showInputDialog("Digite o email:"));
        setNum_conta(JOptionPane.showInputDialog("Digite o número da conta:"));
        setValor_conta(Float.parseFloat(JOptionPane.showInputDialog("Digite o valor da conta:")));
        
    }
    
    public void sacar(){
        int saque;
          if (this.nome == null) {
            JOptionPane.showMessageDialog(null, "Sem conta");
            this.criarConta();
          }else{
            saque = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor do saque: "));
            this.valor_conta -= saque;
            JOptionPane.showMessageDialog(null, "Foi depositado: "+saque + " R$. Seu saldo atual é: "+this.valor_conta+" R$");
        }
        
    }
    
    
    public void exibir(){
                if (getNome()== null) {
            JOptionPane.showMessageDialog(null, "Sem conta");
            this.criarConta();
                }
        String [] dados = {getNome(), getEmail(),getNum_conta()};
        float [] dadoInteiro = {getValor_conta()};
        JOptionPane.showMessageDialog(null, "Nome: "+dados[0]+"\n"+"Email: "+dados[1]+"\n"+"Numero da conta: "+dados[2]+"\n"+"Valor da conta: "+ dadoInteiro[0]);
        
    
    

  }

    
}
