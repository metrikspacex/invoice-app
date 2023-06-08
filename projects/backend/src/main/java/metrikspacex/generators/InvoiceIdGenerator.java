package metrikspacex.generators;

import java.util.Random;
import metrikspacex.entities.Invoice;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

public class InvoiceIdGenerator extends SequenceStyleGenerator {

  @Override
  public Object generate(SharedSessionContractImplementor session,
                         Object object) {
    Random random = new Random();
    String prefix = RandomStringUtils.randomAlphabetic(2).toUpperCase();
    String suffix = String.format("%04d", random.nextInt(10000));

    if ((object != null) && (object instanceof Invoice)) {
      Invoice invoice = (Invoice)object;

      if ((invoice.getId() == null)) {

        System.out.println();
        System.out.println("Nulled");
        System.out.println();
        return prefix + suffix;
      }

      return invoice.getId();
    }

    return super.generate(session, object);
  }
}
