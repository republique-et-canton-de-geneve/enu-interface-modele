package ch.ge.ael.enu.business.domain.v1_0;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@Jacksonized @SuperBuilder
public class SequenceMessages {
    public List<MessageENU> messages;
}
