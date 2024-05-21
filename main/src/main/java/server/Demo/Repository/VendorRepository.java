package server.Demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import server.Demo.Model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long>{

}
