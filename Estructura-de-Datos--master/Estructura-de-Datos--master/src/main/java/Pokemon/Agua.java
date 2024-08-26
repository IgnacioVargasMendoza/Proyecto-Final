package Pokemon;

import javax.swing.JOptionPane;

public class Agua extends Pokemon {

    public Agua(String nombre) {
        super(nombre);
        this.setTipo("Agua");
        this.setVida(190); 
        this.setAtaque(55); 
        this.setDefensa(45); 
        this.setAtaqueEspecial(75); 
        this.setDefensaEspecial(65); 
    }

    @Override
    public int atacar(Pokemon pokemonEnemigo) {
        
        int dañoBase = super.atacar(pokemonEnemigo);
        if (pokemonEnemigo.getTipo().equals("Fuego")) {
            dañoBase *= 1.5; 
        }
        return dañoBase;
    }

    @Override
    public void atacarEspecial(Pokemon pokemonEnemigo) {
      
        int dañoBase = this.getAtaqueEspecial();
        if (pokemonEnemigo.getTipo().equals("Fuego")) {
            dañoBase += 10; 
        }
        aplicarDañoEspecial(pokemonEnemigo, dañoBase);
    }

    @Override
    public void defender(Pokemon pokemonEnemigo) {
        JOptionPane.showMessageDialog(null, this.getNombre() + " se defiende usando una barrera de Agua contra el ataque de " + pokemonEnemigo.getNombre() + "!");
        super.defender(pokemonEnemigo);
    }

    @Override
    public void defensaEspecial(Pokemon pokemonEnemigo) {
      
        JOptionPane.showMessageDialog(null, this.getNombre() + " usa una defensa especial de Agua (Escudo Acuático) contra " + pokemonEnemigo.getNombre() + "!");
        super.defensaEspecial(pokemonEnemigo);
    }
}
