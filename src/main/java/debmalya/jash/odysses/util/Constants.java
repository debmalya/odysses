package debmalya.jash.odysses.util;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.util.Values;

public class Constants {
  public static final String ex = "http://example.org/";

  // Internationalized Resource Identifier
  public static final IRI charge = Values.iri(ex, "Charge");
  public static final IRI partOf = Values.iri(ex, "PartOf");
}
