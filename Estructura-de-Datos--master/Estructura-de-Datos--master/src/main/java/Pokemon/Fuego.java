package Pokemon;

import javax.swing.JOptionPane;

public class Fuego extends Pokemon {

    public Fuego(String nombre) {
        super(nombre);
        this.setTipo("Fuego");
        this.setVida(115); 
        this.setAtaque(70); 
        this.setDefensa(45); 
        this.setAtaqueEspecial(80);
        this.setDefensaEspecial(60); 
    }

    @Override
    public int atacar(Pokemon pokemonEnemigo) {
        int dañoBase = super.atacar(pokemonEnemigo);
        if (pokemonEnemigo.getTipo().equals("Normal")) {
            dañoBase *= 1.5; 
        }
        return dañoBase;
    }

    @Override
    public void atacarEspecial(Pokemon pokemonEnemigo) {
        int dañoBase = this.getAtaqueEspecial();
        if (pokemonEnemigo.getTipo().equals("Normal")) {
            dañoBase += 5; 
        }
        aplicarDañoEspecial(pokemonEnemigo, dañoBase);
    }

    @Override
    public void defensaEspecial(Pokemon pokemonEnemigo) {
        JOptionPane.showMessageDialog(null, this.getNombre() + " usa una defensa especial de Fuego (Escudo de Llamas) contra " + pokemonEnemigo.getNombre() + "!");
        super.defensaEspecial(pokemonEnemigo);
    }
}
