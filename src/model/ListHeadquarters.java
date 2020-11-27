package model;

public class ListHeadquarters {

	// -----------------------------------------------------------------
	// Relations
	// -----------------------------------------------------------------

	private Headquarter first;

	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

	public ListHeadquarters() {
	}

	public String addHeadquarter(Headquarter headquarter) {
		String message = "";
		if (first == null)
			first = headquarter;
		else {
			Headquarter objSearch = searchHeadquarter(headquarter.getNit());
			if (objSearch == null) {
				Headquarter current = first;
				while (current.getNext() != null) {
					current = current.getNext();
				}
				current.setNext(headquarter);
				headquarter.setPrev(current);
				headquarter.setNext(null);
				message = "Headquarter successfully registered.";
			} else
				message = "This headquarter already exists in the system.";
		}
		return message;
	}

	public Headquarter searchHeadquarter(String nit) {
		Headquarter exist = first;
		if (first != null) {
			while (!exist.getNext().getNit().equals(first.getNit()) && !exist.getNit().equals(nit))
				exist = exist.getNext();
			if (exist.getNit().equals(first.getPrev().getNit())) {
				if (!exist.getNit().equals(nit))
					exist=null;
			}
		}
		return exist;
	}

	public String removeHeadquarter(String nit) { // verify later
		String message = "";
		Headquarter headquarter = null;
		if (first != null) {
			if (nit.equals(first.getNit())) {
				headquarter = first;
				first.getNext().setPrev(null);
				first = first.getNext();
				message = "The headquarter with NIT " + headquarter.getNit();
			} else {
				Headquarter current = searchHeadquarter(nit).getPrev();
				if (current.getNext() != null ) {
					headquarter = current.getNext();
					current.getNext().getNext().setPrev(current);
					current.setNext(current.getNext().getNext());
					message = "The headquarter with NIT " + headquarter.getNit();
				}
			}
		} else
			message = "There are no headquarters registered in the system to remove one.";
		return message;
	}
}