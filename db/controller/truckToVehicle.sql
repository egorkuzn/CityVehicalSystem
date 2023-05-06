select VTM.vehicle_id::text || '|'|| TM.model_name as model_name,
       VTM.vehicle_id
from "Trucks models" as TM
     left join "Vehicle-Truck model" as VTM
         on TM.truck_model_id = VTM.truck_id
where vehicle_id notnull


