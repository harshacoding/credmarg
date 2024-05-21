package server.Demo.Service;

import java.util.List;

import server.Demo.Model.Vendor;

public interface VendorService {
	Vendor saveVendor(Vendor vendor);
    List<Vendor> getAllVendors();
    Vendor getVendorById(Long id);

}
