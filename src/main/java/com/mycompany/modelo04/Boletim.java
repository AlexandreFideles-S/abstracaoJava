/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo04;

/**
 *
 * @author Fideles
 */
public class Boletim {

    public static double calcularMedia(NotasAluno notas) {
        double nota1 = notas.getNota1();
        double nota2 = notas.getNota2();
        double nota3 = notas.getNota3();

        double media = (nota1 + nota2 + nota3)/3;
        return media;


    }

    public static String VerificarSituacao(double media) {
        String resultado = "";
        if (media >= 6) {
            resultado = "Aprovado";
        } else {
            resultado = "DP";
        }

        return resultado;
    }

}
