/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pokemon;

/**
 *
 * @author Ignac
 */
public class Normal extends Pokemon {

    public Normal(int id, String nombre) {
        super(id, nombre);
        this.setVida(150);
        this.setHPAtaque(50);
        this.setHPDefensa(35);
        this.setHPAtaqueEspecial(70);
        this.setHPDefensaEspecial(60);
        this.setTipo("Normal");
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
