/*
The MIT License (MIT)

Copyright (c) 2015 psygate (https://github.com/psygate)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package com.psygate.meteorites.meteor;

import com.psygate.meteorites.math.Vector;
import org.bukkit.Material;
import org.bukkit.block.Block;

/**
 *
 * @author psygate (https://github.com/psygate)
 */
public class SafeNotAirNotScorchedBlock extends SafeBlock {

    public SafeNotAirNotScorchedBlock(Vector v) {
        super(v);
    }

    @Override
    protected void load() {
        super.load();
        if(block != null && (Cache.isAir(v) || Cache.isScorched(v))) {
            block = null;
        }
//        if (!loaded && block == null && !Cache.isScorched(v) && !Cache.isNoMod(v) && !Cache.isAir(v)) {
//            block = this.v.asLocation().getBlock();
//            loaded = true;
//        }
    }

    @Override
    public boolean setType(Material m) {
        boolean out = super.setType(m);
        Cache.setScorched(v);
        return out;
    }

}