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

	public void addHeadquarter(Headquarter headquarter) {
		if (first == null)
			first = headquarter;
		else {
			while (first.getNext() != null) {
				first = first.getNext();
			}
			first.setNext(headquarter);
			headquarter.setPrev(first);
			headquarter.setNext(null);
		}
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

	public String removeHeadquarter(String nit) {
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
		}
		return message;
	}
}
