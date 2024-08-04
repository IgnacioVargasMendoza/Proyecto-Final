/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pokemon;

/**
 *
 * @author Ignac
 */
public class Agua extends Pokemon{

    public Agua(int id, String nombre) {
        super(id, nombre);
        this.setVida(190);
        this.setHPAtaque(55);
        this.setHPDefensa(45);
        this.setHPAtaqueEspecial(75);
        this.setHPDefensaEspecial(65);
        this.setTipo("Agua");
    }

    @Override
    public void ataqueEspecial() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void DefensaEspecial() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
