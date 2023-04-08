create or replace function is_already_mapped_to_vehicle_type() returns trigger as $$
begin
    if exists (
        select 1
        from "Vehicle-Truck model" as VTM,
             "Vehicle-Auxiliary model" as VAM,
             "Vehicle-Bus model" as VBM,
             "Vehicle-Car model" as VCM,
             "Vehicle-Shuttle model" as VSM,
             "Vehicle-Taxi model" as VTM
        where not ((NEW.vehicle_id = VTM.vehicle_id)
            AND (NEW.vehicle_id = VAM.vehicle_id)
            AND (NEW.vehicle_id = VBM.vehicle_id)
            AND (NEW.vehicle_id = VCM.vehicle_id)
            AND (NEW.vehicle_id = VSM.vehicle_id)
            AND (NEW.vehicle_id = VTM.vehicle_id))
    ) then
        raise exception 'Duplicate found';
    end if;
    return new;
end;
$$ language plpgsql;