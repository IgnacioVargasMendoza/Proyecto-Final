package Pokemon;

import javax.swing.JOptionPane;

public class Normal extends Pokemon {

    public Normal(String nombre) {
        super(nombre);
        this.setTipo("Normal");
        this.setVida(150); // Vida base para Pokémon de tipo Normal
        this.setAtaque(50); // Ataque base para Pokémon de tipo Normal
        this.setDefensa(35); // Defensa base para Pokémon de tipo Normal
        this.setAtaqueEspecial(70); // Ataque especial base para Pokémon de tipo Normal
        this.setDefensaEspecial(60); // Defensa especial base para Pokémon de tipo Normal
    }

    @Override
    public int atacar(Pokemon pokemonEnemigo) {
        int dañoBase = super.atacar(pokemonEnemigo);
        if (pokemonEnemigo.getTipo().equals("Agua")) {
            dañoBase *= 0.5; // Reducir daño contra Pokémon de tipo Agua
        }
        return dañoBase;
    }

    @Override
    public void atacarEspecial(Pokemon pokemonEnemigo) {
        int dañoBase = this.getAtaqueEspecial();
        if (pokemonEnemigo.getTipo().equals("Agua")) {
            dañoBase += 5; // Incrementar daño especial contra Pokémon de tipo Agua
        }
        aplicarDañoEspecial(pokemonEnemigo, dañoBase);
    }

    @Override
    public void defensaEspecial(Pokemon pokemonEnemigo) {
        JOptionPane.showMessageDialog(null, this.getNombre() + " usa una defensa especial Normal (Escudo de Energía) contra " + pokemonEnemigo.getNombre() + "!");
        super.defensaEspecial(pokemonEnemigo);
    }
}
