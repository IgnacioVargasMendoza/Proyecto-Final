package Pokemon;

import javax.swing.JOptionPane;

public class Agua extends Pokemon {

    public Agua(String nombre) {
        super(nombre);
        this.setTipo("Agua");
        this.setVida(190); // Vida base para Pokémon de tipo Agua
        this.setAtaque(55); // Ataque base para Pokémon de tipo Agua
        this.setDefensa(45); // Defensa base para Pokémon de tipo Agua
        this.setAtaqueEspecial(75); // Ataque especial base para Pokémon de tipo Agua
        this.setDefensaEspecial(65); // Defensa especial base para Pokémon de tipo Agua
    }

    @Override
    public int atacar(Pokemon pokemonEnemigo) {
        // Ajusta el daño si el enemigo es de tipo Fuego
        int dañoBase = super.atacar(pokemonEnemigo);
        if (pokemonEnemigo.getTipo().equals("Fuego")) {
            dañoBase *= 1.5; // Incremento del 50% en daño contra Pokémon de tipo Fuego
        }
        return dañoBase;
    }

    @Override
    public void atacarEspecial(Pokemon pokemonEnemigo) {
        // Ajusta el daño si el enemigo es de tipo Fuego
        int dañoBase = this.getAtaqueEspecial();
        if (pokemonEnemigo.getTipo().equals("Fuego")) {
            dañoBase += 10; // Aumenta el daño especial contra Pokémon de tipo Fuego
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
        // Ajusta la defensa especial si el enemigo es de tipo Fuego
        JOptionPane.showMessageDialog(null, this.getNombre() + " usa una defensa especial de Agua (Escudo Acuático) contra " + pokemonEnemigo.getNombre() + "!");
        super.defensaEspecial(pokemonEnemigo);
    }
}
