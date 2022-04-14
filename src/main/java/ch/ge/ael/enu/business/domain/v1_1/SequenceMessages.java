package ch.ge.ael.enu.business.domain.v1_1;

import ch.ge.ael.enu.business.domain.v1_0.MessageENU;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@Jacksonized @SuperBuilder
public class SequenceMessages {
    public List<MessageENU> messages;
}
