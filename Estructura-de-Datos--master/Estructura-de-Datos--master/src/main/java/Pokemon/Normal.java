package Pokemon;

import javax.swing.JOptionPane;

public class Normal extends Pokemon {

    public Normal(String nombre) {
        super(nombre);
        this.setTipo("Normal");
        this.setVida(150); 
        this.setAtaque(50); 
        this.setDefensa(35); 
        this.setAtaqueEspecial(70); 
        this.setDefensaEspecial(60); 
    }

    @Override
    public int atacar(Pokemon pokemonEnemigo) {
        int dañoBase = super.atacar(pokemonEnemigo);
        if (pokemonEnemigo.getTipo().equals("Agua")) {
            dañoBase *= 0.5; 
        }
        return dañoBase;
    }

    @Override
    public void atacarEspecial(Pokemon pokemonEnemigo) {
        int dañoBase = this.getAtaqueEspecial();
        if (pokemonEnemigo.getTipo().equals("Agua")) {
            dañoBase += 5;
        }
        aplicarDañoEspecial(pokemonEnemigo, dañoBase);
    }

    @Override
    public void defensaEspecial(Pokemon pokemonEnemigo) {
        JOptionPane.showMessageDialog(null, this.getNombre() + " usa una defensa especial Normal (Escudo de Energía) contra " + pokemonEnemigo.getNombre() + "!");
        super.defensaEspecial(pokemonEnemigo);
    }
}
