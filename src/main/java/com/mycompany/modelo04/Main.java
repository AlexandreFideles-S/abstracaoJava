/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.modelo04;

/**
 *
 * @author Fideles
 */
public class Main {

    public static void main(String[] args) {
        NotasAluno notas = new NotasAluno();
                
        notas.setNota1(5);
        notas.setNota2(8);
        notas.setNota3(8);

        double media = Boletim.calcularMedia(notas);
        System.out.println(media);
        
        String verif = Boletim.VerificarSituacao(media);
        System.out.println(verif);

    }
}
