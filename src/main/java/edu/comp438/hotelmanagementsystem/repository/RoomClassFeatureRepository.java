package edu.comp438.hotelmanagementsystem.repository;

import edu.comp438.hotelmanagementsystem.entity.RoomClassFeature;
import edu.comp438.hotelmanagementsystem.entity.RoomClassFeatureId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomClassFeatureRepository extends JpaRepository<RoomClassFeature, RoomClassFeatureId> {
}
