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

    public Fuego(String nombre) {
        super(nombre);
        this.setVida(115);
        this.setAtaque(70);
        this.setDefensa(45);
        this.setAtaqueEspecial(80);
        this.setDefensaEspecial(60);
        this.setTipo("Fuego");
    }

    @Override
    public void ataqueEspecial() {
        System.out.println("ataqueEspecial Fuego");
    }

    @Override
    public void defensaEspecial() {
        System.out.println("defensaEspecial Fuego");
    }


}
