import { useState } from "react";
import AvailabilitySlot from "./AvailabilitySlot";

interface AccordionProps{
    day: string,
    slots: any[],
    onSelectSlot: (id: string) => void;
}


const AvailabilityAccordion = ({day, slots, onSelectSlot}: AccordionProps) =>{
    const [isOpen, setIsOpen] = useState(false);

    return(
        <div className="flex flex-col justify-center m-3 rounded-xl overflow-hidden border-2 border-[#0B5976] bg-gray-200">
            <button
                onClick={() => setIsOpen(!isOpen)}
                className="text-xl tracking-[0.05em] py-2"
            >
                <span className="px-2">{day}</span>
                
                <span className="px-2">
                    {isOpen === true ? ("▼") : ("▶")}
                </span>
            </button>

            {isOpen && (
                <div className="p-2">
                    {slots.map((slot) => (
                        <div key={slot.slotId} onClick={() => onSelectSlot(slot.slotId)}>
                            <AvailabilitySlot {...slot}/>
                        </div>
                    ))}
                </div>
            )}
        </div>
    )
}

export default AvailabilityAccordion;