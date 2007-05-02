﻿/*
Facsimile -- A Discrete-Event Simulation Library
Copyright © 2004-2007, Michael J Allen.

This program is free software; you can redistribute it and/or modify it under
the terms of the GNU General Public License as published by the Free Software
Foundation; either version 2 of the License, or (at your option) any later
version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY
WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
PARTICULAR PURPOSE.  See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with
this program; if not, write to the:

    Free Software Foundation, Inc.
    51 Franklin St, Fifth Floor
    Boston, MA  02110-1301
    USA

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

C# source file for the MassUnitTest class, and associated elements, that are
integral members of the Facsimile.CommonTest namespace.
===============================================================================
*/

using NUnit.Framework;
using Facsimile.Common;
namespace Facsimile.CommonTest {

//=============================================================================
/**
<summary>NUnit test fixture for the <see cref="MassUnit" /> class.</summary>
*/
//=============================================================================

    [TestFixture]
    public sealed class MassUnitTest
    {

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/**
<summary>Tests that the <see cref="MeasurementUnit.GetStandard (System.Type)"
/> function identifies the correct standard units.</summary>
*/
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        [Test]
        public void VerifyGetStandard ()
        {
            Assert.AreSame (MassUnit.Kilograms, MeasurementUnit.GetStandard
            (typeof (MassUnit)));
        }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/**
<summary>Tests that the <see cref="MassUnit.IsStandard" /> property correctly
identifies standard and non-standard units.</summary>
*/
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        [Test]
        public void VerifyIsStandard ()
        {
            Assert.IsTrue (MassUnit.Kilograms.IsStandard);
            Assert.IsFalse (MassUnit.Grams.IsStandard);
            Assert.IsFalse (MassUnit.Milligrams.IsStandard);
            Assert.IsFalse (MassUnit.Tonnes.IsStandard);
            Assert.IsFalse (MassUnit.Pounds.IsStandard);
            Assert.IsFalse (MassUnit.Ounces.IsStandard);
        }
    }
}
