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

Java source file belonging to the org.facsim.facsimile.util package.
*/
//=============================================================================

package org.facsim.facsimile.util;

//=============================================================================
/**
<p>Denotes test code.</p>

<p>Classes and/or functions that are decorated with this annotation are used
for testing <em>Facsimile</em> code; they should not be used or referenced
either within the main <em>Facsimile</em> codebase, or within user third-party
code.</p>

<p>This is, admittedly, ugly, and inevitably leads to pollution of the public
<em>Facsimile</em> API.  However, it's preferable to exposing key parts of the
system to abuse simply to permit more elegant testing.</p>

<p>TODO: Issue warnings if code decorated with this annotation is used
inappropriately.</p>
*/
//=============================================================================

public @interface TestCode
{
}
