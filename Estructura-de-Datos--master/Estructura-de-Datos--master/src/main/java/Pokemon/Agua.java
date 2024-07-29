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
        this.setAtaque(55);
        this.setDefensa(45);
        this.setAtaqueEspecial(75);
        this.setDefensaEspecial(65);
        this.setTipo("Agua");
    }
    
}
