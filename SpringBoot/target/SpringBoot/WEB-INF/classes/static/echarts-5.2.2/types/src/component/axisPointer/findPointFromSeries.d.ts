import GlobalModel from '../../model/Global';
import Element from 'zrender/lib/Element';
/**
 * @param finder contains {seriesIndex, dataIndex, dataIndexInside}
 * @param ecModel
 * @return  {point: [x, y], el: ...} point Will not be null.
 */
export default function findPointFromSeries(finder: {
    seriesIndex?: number;
    dataIndex?: number | number[];
    dataIndexInside?: number | number[];
    name?: string | string[];
    isStacked?: boolean;
}, ecModel: GlobalModel): {
    point: number[];
    el?: Element;
};
