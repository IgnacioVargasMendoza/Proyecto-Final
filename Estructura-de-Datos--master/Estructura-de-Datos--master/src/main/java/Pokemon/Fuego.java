/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pokemon;

/**
 *
 * @author Ignac
 */
public class Fuego extends Pokemon{

    public Fuego(int id, String nombre) {
        super(id, nombre);
        this.setVida(115);
        this.setHPAtaque(70);
        this.setHPDefensa(45);
        this.setHPAtaqueEspecial(80);
        this.setHPDefensaEspecial(60);
        this.setTipo("Fuego");
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
