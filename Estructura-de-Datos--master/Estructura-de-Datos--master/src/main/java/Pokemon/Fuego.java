package Pokemon;

import javax.swing.JOptionPane;

public class Fuego extends Pokemon {

    public Fuego(String nombre) {
        super(nombre);
        this.setTipo("Fuego");
        this.setVida(115); // Vida base para Pokémon de tipo Fuego
        this.setAtaque(70); // Ataque base para Pokémon de tipo Fuego
        this.setDefensa(45); // Defensa base para Pokémon de tipo Fuego
        this.setAtaqueEspecial(80); // Ataque especial base para Pokémon de tipo Fuego
        this.setDefensaEspecial(60); // Defensa especial base para Pokémon de tipo Fuego
    }

    @Override
    public int atacar(Pokemon pokemonEnemigo) {
        int dañoBase = super.atacar(pokemonEnemigo);
        if (pokemonEnemigo.getTipo().equals("Normal")) {
            dañoBase *= 1.5; // Incrementar daño contra Pokémon de tipo Normal
        }
        return dañoBase;
    }

    @Override
    public void atacarEspecial(Pokemon pokemonEnemigo) {
        int dañoBase = this.getAtaqueEspecial();
        if (pokemonEnemigo.getTipo().equals("Normal")) {
            dañoBase += 5; // Incrementar daño especial contra Pokémon de tipo Normal
        }
        aplicarDañoEspecial(pokemonEnemigo, dañoBase);
    }

    @Override
    public void defensaEspecial(Pokemon pokemonEnemigo) {
        JOptionPane.showMessageDialog(null, this.getNombre() + " usa una defensa especial de Fuego (Escudo de Llamas) contra " + pokemonEnemigo.getNombre() + "!");
        super.defensaEspecial(pokemonEnemigo);
    }
}
