
package com.smartvoucher.webEcommercesmartvoucher.controller;

import com.smartvoucher.webEcommercesmartvoucher.dto.WarehouseStoreDTO;
import com.smartvoucher.webEcommercesmartvoucher.entity.keys.WarehouseStoreKeys;
import com.smartvoucher.webEcommercesmartvoucher.payload.ResponseObject;
import com.smartvoucher.webEcommercesmartvoucher.service.IWarehouseStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/warehouse_store")
public class WarehouseStoreController {
    private IWarehouseStoreService warehouseStoreService;
    @Autowired
    public WarehouseStoreController(IWarehouseStoreService warehouseStoreService) {
        this.warehouseStoreService = warehouseStoreService;
    }
    @GetMapping("")
    @Transactional(readOnly = true)
    public ResponseEntity<ResponseObject> getAllWarehouseStore(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(
                        200,
                        "Get all WarehouseStore",
                        this.warehouseStoreService.getAllWarehouseStore()
                )
        );
    }
    @PostMapping("/api/insert")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<ResponseObject> insertWarehouseStore(@Valid @RequestBody WarehouseStoreDTO warehouseStoreDTO){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(
                        200,
                        "Insert completed",
                        this.warehouseStoreService.insert(warehouseStoreDTO)
                )
        );
    }
    @DeleteMapping("/api/delete")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<ResponseObject> deleteWarehouseStore(@RequestBody WarehouseStoreDTO warehouseStoreDTO,
                                                               @RequestParam Long idWarehouse, @RequestParam Long idStore){
        warehouseStoreDTO.getIdWarehouse();
        warehouseStoreDTO.getIdStore();
        warehouseStoreService.delete(warehouseStoreDTO);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(
                        200,
                        "Delete completed",
                        "{}"
                )
        );
    }


}
