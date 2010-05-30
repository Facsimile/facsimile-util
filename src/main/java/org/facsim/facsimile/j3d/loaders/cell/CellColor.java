/*
Facsimile -- A Discrete-Event Simulation Library
Copyright © 2004-2010, Michael J Allen.

This file is part of Facsimile.

Facsimile is free software: you can redistribute it and/or modify it under the
terms of the GNU General Public License as published by the Free Software
Foundation, either version 3 of the License, or (at your option) any later
version.

Facsimile is distributed in the hope that it will be useful, but WITHOUT ANY
WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
A PARTICULAR PURPOSE.  See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with
Facsimile.  If not, see http://www.gnu.org/licenses/.

The developers welcome all comments, suggestions and offers of assistance.
For further information, please visit the project home page at:

	http://www.facsim.org/

Thank you for your interest in the Facsimile project!

IMPORTANT NOTE: All patches (modifications to existing files and/or the
addition of new files) submitted for inclusion as part of the official
Facsimile code base, must comply with the published Facsimile Coding Standards.
If your code fails to comply with the standard, then your patches will be
rejected.  For further information, please visit the coding standards at:

	http://www.facsim.org/Documentation/CodingStandards/
===============================================================================
$Id$

Java source file belonging to the org.facsim.facsimile.j3d.loaders.cell
package.
*/
//=============================================================================

package org.facsim.facsimile.j3d.loaders.cell;

import javax.vecmath.Color3b;
import net.jcip.annotations.Immutable;
import org.facsim.facsimile.util.PackagePrivate;
import com.sun.j3d.loaders.IncorrectFormatException;
import com.sun.j3d.loaders.ParsingErrorException;

//=============================================================================
/**
<p><em>Cell</em> color code enumerator.</p>

<p>The color code values, and RGB values listed here, are obtained from the
default <code>.asilibrc</code> file generated by <em>AutoMod</em>.
<em>AutoMod</em> will honor changes to the RGB values written into the
<code>.asilibrc</code> file, but we currently do not support the possibility of
reading color RGB values from this file.</p>
*/
//=============================================================================

@Immutable
@PackagePrivate
enum CellColor
{

/**
<p><em>Cell</em> color black.</p>
*/

    CC_BLACK ((byte) 0, new Color3b ((byte) 0, (byte) 0, (byte) 0)),

/**
<p><em>Cell</em> color red.</p>
*/

    CC_RED ((byte) 1, new Color3b ((byte) 255, (byte) 0, (byte) 0)),

/**
<p><em>Cell</em> color green.</p>
*/

    CC_GREEN ((byte) 2, new Color3b ((byte) 0, (byte) 255, (byte) 0)),

/**
<p><em>Cell</em> color yellow.</p>
*/

    CC_YELLOW ((byte) 3, new Color3b ((byte) 255, (byte) 255, (byte) 0)),

/**
<p><em>Cell</em> color blue.</p>
*/

    CC_BLUE ((byte) 4, new Color3b ((byte) 0, (byte) 0, (byte) 255)),

/**
<p><em>Cell</em> color magenta.</p>
*/

    CC_MAGENTA ((byte) 5, new Color3b ((byte) 255, (byte) 0, (byte) 255)),

/**
<p><em>Cell</em> color cyan.</p>
*/

    CC_CYAN ((byte) 6, new Color3b ((byte) 0, (byte) 255, (byte) 255)),

/**
<p><em>Cell</em> color white.</p>
*/

    CC_WHITE ((byte) 7, new Color3b ((byte) 255, (byte) 255, (byte) 255)),

/**
<p><em>Cell</em> color light gray.</p>
*/

    CC_LIGHT_GRAY ((byte) 8, new Color3b ((byte) 163, (byte) 163, (byte) 163)),

/**
<p><em>Cell</em> color dark gray.</p>
*/

    CC_DARK_GRAY ((byte) 9, new Color3b ((byte) 91, (byte) 91, (byte) 91)),

/**
<p><em>Cell</em> color brown.</p>
*/

    CC_BROWN ((byte) 10, new Color3b ((byte) 127, (byte) 72, (byte) 0)),

/**
<p><em>Cell</em> color light blue.</p>
*/

    CC_LIGHT_BLUE ((byte) 11, new Color3b ((byte) 63, (byte) 145, (byte) 255)),

/**
<p><em>Cell</em> color purple.</p>
*/

    CC_PURPLE ((byte) 12, new Color3b ((byte) 127, (byte) 0, (byte) 255)),

/**
<p><em>Cell</em> color orange.</p>
*/

    CC_ORANGE ((byte) 13, new Color3b ((byte) 255, (byte) 36, (byte) 0)),

/**
<p><em>Cell</em> color light green.</p>
*/

    CC_LIGHT_GREEN ((byte) 14, new Color3b ((byte) 127, (byte) 255, (byte)
    63)),

/**
<p><em>Cell</em> color light yellow.</p>
*/

    CC_LIGHT_YELLOW ((byte) 15, new Color3b ((byte) 255, (byte) 255, (byte)
    63));

/**
<p>Array associating each color code with the associated enumerated color
constant.</p>

<p>This array must be populated during static initialization of the
enumeration, since the (static) enumerations are created before the static
initializer is invoked.</p>
*/

    private final static CellColor colorArray [];

/**
<p><em>Cell</em> color code value.</p>
*/

    private final byte code;

/**
<p><em>Java3D</em> color corresponding to each enumerated color object.</em>
*/

    private final Color3b color;

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/**
<p>Static initialization.</p>

<p>Note that static initialization is performed <em>after</em> each enumeration
constant has been constructed.</p>
*/
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    static
    {

/*
Create the array that allows each color enumeration to be looked up from the
corresponding color code.
*/

        assert CellColor.values ().length <= Byte.MAX_VALUE;
        colorArray = new CellColor [CellColor.values ().length];

/*
Populate the array from the corresponding codes.

This loop will only work if the colors are defined in order of their color
codes.
*/

        byte colorCode = 0;
        for (CellColor cellColor: CellColor.values ())
        {
            assert cellColor.getCode () == colorCode;
            colorArray [colorCode] = cellColor;
            ++colorCode;
        }
    }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/**
<p>Retrieve Color instance from a tokenized cell data stream.<p>

@param tokenizer Tokenized stream from which the color code will be read.  The
next token to be read should be a cell color code.

@return Cell color instance read from the stream.

@throws IncorrectFormatException If the tokenizer does not identify a valid
<em>cell</em> color code.

@throws ParsingErrorException If an error occurs while parsing the tokenized
<em>cell</em> color code.
*/
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    @PackagePrivate
    static CellColor readColor (CellTokenizer tokenizer)
    throws IncorrectFormatException, ParsingErrorException
    {

/*
Attempt to read the cell's color code from the file.
*/

        byte cellColorCode = tokenizer.readByteField ();

/*
Now convert the code into a cell color.  It if is not a code we recognize, then
that would be a parse error.
*/

        if (cellColorCode < 0 || cellColorCode > colorArray.length)
        {
            throw new ParsingErrorException ();
        }

/*
Retrieve and return the matching value.
*/

        assert colorArray [cellColorCode] != null;
        return colorArray [cellColorCode];
    }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/**
<p>Retrieve default cell color if not explicitly specified.</p>

@return Default color to be assumed if not explicitly specified.
*/
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    @PackagePrivate
    static CellColor getDefault ()
    {
        return CC_RED;
    }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/**
<p>Enumeration constant constructor.</p>

<p>Note that this constructor is called for each enumeration before the
enumeration's static initializer.</p>

@param code Corresponding color code for each enumeration constant.

@param color Color for each enumeration constant.
*/
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    private CellColor (byte code, Color3b color)
    {

/*
Store the result.
*/

        this.code = code;
        this.color = color;
    }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/**
<p>Retrieve color code for corresponding enumeration.</p>

@return The integer code for this color.
*/
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public final byte getCode ()
    {
        return this.code;
    }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/**
<p>Retrieve corresponding color.</p>

@return <em>Java3D</em> color corresponding to this <em>cell</em> color.
*/
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public final Color3b getColor ()
    {
        return this.color;
    }
}
