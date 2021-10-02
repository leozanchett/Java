package aplicacao;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class programa {

	public static void main(String[] args) {
		/*Pessoa p1 = new Pessoa(null, "Carlos da silva", "calos@gmail.com");
		Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
		Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");*/

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

		Pessoa p = em.find(Pessoa.class, 2);
		System.out.println(p);

		/*em.getTransaction().begin(); // sempre que alterar a estrutura do bd com exceção de consultas é necessário iniciar uma transação.
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();*/

		em.clear();
		em.close();
		emf.close();
	}

}
