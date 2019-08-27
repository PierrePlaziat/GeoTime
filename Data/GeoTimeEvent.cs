using System;
using System.Collections.Generic;
using System.Device.Location;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GeoTime.Data
{
    // SpaceTime Point
    class GeoTimeEvent 
    {
        int id;
        DateTime when;
        GeoCoordinate where;
        string title;
        string data;
    }
}
