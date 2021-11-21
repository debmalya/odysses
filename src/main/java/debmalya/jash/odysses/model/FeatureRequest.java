package debmalya.jash.odysses.model;

import lombok.Data;

@Data
public class FeatureRequest {
  private String feature;
  private CombinedPlans plans;
}
