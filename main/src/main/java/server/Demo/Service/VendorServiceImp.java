package server.Demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.Demo.Model.Vendor;
import server.Demo.Repository.VendorRepository;

@Service
public class VendorServiceImp implements VendorService{
	@Autowired
    private VendorRepository vendorRepository;

    @Override
    public Vendor saveVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    @Override
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }
    
    @Override
    public Vendor getVendorById(Long id) {
        return vendorRepository.findById(id).orElse(null);
    }

 
}
