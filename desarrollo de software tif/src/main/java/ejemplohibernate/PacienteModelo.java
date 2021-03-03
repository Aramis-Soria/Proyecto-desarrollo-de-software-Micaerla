package ejemplohibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class PacienteModelo {
	protected SessionFactory sessionFactory;
	
	protected void setup() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch(Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
	
	protected void exit() {
		sessionFactory.close();
	}
	
	protected void crear() {
		PacienteEntidad paciente = new PacienteEntidad();
		paciente.setNom_paciente("Luly");
		paciente.setNom_dueño("Joaquin");
		paciente.setN_telefono("12345678");
		paciente.setMail("joa@gmail.com");
		paciente.setDireccion("berazategui");
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(paciente);
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	
	private PacienteEntidad leer(int idpaciente) {
		Session session = sessionFactory.openSession();
		
		PacienteEntidad paciente = session.get(PacienteEntidad.class, idpaciente);
		
		session.close();
		return paciente;
			
	}
	
	
	
	protected void actualiza(int idpaciente) {
		PacienteEntidad paciente = this.leer(idpaciente);
		
		paciente.setNom_paciente("moly");
		paciente.setNom_dueño("Joa");
		paciente.setN_telefono("12666678");
		paciente.setMail("joa@ghotmail.com");
		paciente.setDireccion("bera");
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.update(paciente);
		
		session.getTransaction().commit();
		
		session.close();
	
	}
	
	protected void borrar(int idpaciente) {
		PacienteEntidad paciente = new PacienteEntidad();
		paciente.setIdPaciente(idpaciente);
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		session.delete(paciente);
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	public static void main(String[]args) {
		PacienteModelo usuarioManager = new PacienteModelo();
		usuarioManager.setup();
		
		
	}
}
