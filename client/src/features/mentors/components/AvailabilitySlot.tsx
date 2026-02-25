import type { AvailabilitySlotProps } from "../../../types/mentor"

const AvailabilitySlot = ({slotId, startTime, endTime, status}: AvailabilitySlotProps) => {
    var baseStyle = "border-2 rounded-xl overflow-hidden w-full p-2 place-items-center"
    var componentStyle = "bg-green-200";

    if(status == "seleccionado") componentStyle = "bg-orange-200";
    else if (status == "reservado") componentStyle = "bg-red-200";

    baseStyle+=" " + componentStyle;

    return (
        <div className={baseStyle}>
            <div className="flex flex-row p-1">
                <p className="p-2 mx-1">
                    {new Date(startTime).toLocaleTimeString('es-ES', {hour: '2-digit', minute: '2-digit'})} - {new Date(endTime).toLocaleTimeString('es-ES', {hour: '2-digit', minute: '2-digit'})}
                </p>

                <button key={slotId} className="border border-2 rounded-2xl p-2 mx-1 hover:scale-[1.02]"> Reservar </button>
            </div>
        </div>
    )
}

export default AvailabilitySlot;