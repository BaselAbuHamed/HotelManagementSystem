package edu.comp438.hotelmanagementsystem.repository;

import edu.comp438.hotelmanagementsystem.entity.RoomClassBedType;
import edu.comp438.hotelmanagementsystem.entity.RoomClassBedTypeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomClassBedTypeRepository extends JpaRepository<RoomClassBedType, RoomClassBedTypeId> {
}
