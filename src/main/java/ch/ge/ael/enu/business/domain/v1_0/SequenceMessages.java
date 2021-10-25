package ch.ge.ael.enu.business.domain.v1_0;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SequenceMessages {
    public List<MessageENU> messages;
}
