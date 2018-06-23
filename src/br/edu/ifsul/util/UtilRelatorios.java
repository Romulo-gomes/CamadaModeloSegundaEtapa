/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.util;

import br.edu.ifsul.modelo.Consulta;
import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Exame;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author romulo
 */
public class UtilRelatorios {
    
    public static List<Exame> listaExames(){
        List<Exame> lista = new ArrayList<>();
        Exame e1 = new Exame();
        e1.setNome("Sangue");
        e1.setDescricao("Exame de Hemoglobina");
        Exame e2 = new Exame();
        e2.setNome("Raio-X");
        e2.setDescricao("Raio-X do Torax");
        Exame e3 = new Exame();
        e3.setNome("Eletrocardiograma");
        e3.setDescricao("Eletrocardiograma do coração");
        Exame e4 = new Exame();
        e2.setNome("Visão");
        e2.setDescricao("Exame de Vista");
        
        lista.add(e1);
        lista.add(e2);
        lista.add(e3);
        lista.add(e4);
        
        
        return lista;
        
    }
    
}
