create or replace function is_already_mapped_to_vehicle_type() returns trigger as $$
begin
    if exists (
        select 1
        from "Vehicle-Truck model" as VTruckM
        where new.vehicle_id = VTruckM.vehicle_id
    ) or exists (
        select 1
        from "Vehicle-Auxiliary model" as VAM
        where new.vehicle_id = VAM.vehicle_id
    ) or exists (
        select 1
        from "Vehicle-Bus model" as VBM
        where new.vehicle_id = VBM.vehicle_id
    ) or exists (
        select 1
        from "Vehicle-Car model" as VCM
        where new.vehicle_id = VCM.vehicle_id
    ) or exists (
        select 1
        from "Vehicle-Shuttle model" as VSM
        where (new.vehicle_id = VSM.vehicle_id)
    ) or exists (
        select 1
        from "Vehicle-Taxi model" as VTaxiM
        where (new.vehicle_id = VTaxiM.vehicle_id)
    ) then
        raise exception 'Duplicate found';
    end if;
    return new;
end;
$$ language plpgsql;

